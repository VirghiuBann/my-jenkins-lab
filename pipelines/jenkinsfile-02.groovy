pipeline {
    agent {
        docker {
            image 'node:lts-alpine'
        }
    }

    stages {
        stage('Build') {
            steps {
                sh 'node -v'
            }
        }
    }
}