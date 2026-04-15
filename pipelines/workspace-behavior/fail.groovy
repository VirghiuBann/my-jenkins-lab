pipeline {
    agent none

    stages {
        stage('Create File') {
            agent {
                docker { image 'node:lts-alpine' }
            }
            steps {
                sh 'echo Hello > file.txt'
            }
        }

        stage('Read File') {
            agent {
              node {
                label 'docker-agent-alpine'
              }
            }
            steps {
                sh 'cat file.txt'
            }
        }
    }
}