pipeline {
    agent none

    stages {
        stage('Create File') {
            agent {
                docker { image 'node:lts-alpine' }
            }
            steps {
                sh 'echo Hello > file.txt'
                stash includes: 'file.txt', name: 'myfile'
            }
        }

        stage('Read File') {
            agent {
              node {
                label 'docker-agent-alpine'
              }
            }
            steps {
                unstash 'myfile'
                sh 'cat file.txt'
            }
        }
    }
}
