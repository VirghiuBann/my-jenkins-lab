pipeline {
    agent { 
        node {
            label 'docker-agent-alpine'
            }
      }
    stages {
        stage('Check Agent') {
            steps {
                echo "Running on: ${env.NODE_NAME}"                
            }
        }
    }
}