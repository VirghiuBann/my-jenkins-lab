pipeline {
    agent none

    stages {
        stage('Node') {
            agent {
                docker { image 'node:lts-alpine' }
            }
            steps {
                sh 'node -v'
            }
        }

        stage('Python') {
            agent {
                docker { image 'python:3.14.4' }
            }
            steps {
                sh 'python --version'
            }
        }
    }
}