pipeline {
    agent any
    stages {
        stage('Clone'){
            steps{
                git branch:'main', url: 'https://github.com/RalucaE/Jenkins'
            }
        }
        stage('Build') {
            steps {                                    
              powershell '''
             cd spring/
             docker build -t spring-image .            
             docker build -t postgres-image .
             cd ..
             cd angular/
             docker build -t angular-image .
             cd ..
              '''
            }
        }
    stage('Build and Run Docker Compose') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com/', 'dockerhub-creds') {
                        powershell 'docker-compose up -d'
                    }
                }
            }
        }
    }
}