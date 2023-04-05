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
                environment{
                    env.PATH = env.PATH + ";c:\\Windows\\System32"
                }        
            
              bat '''
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
                        bat 'docker-compose up -d'
                    }
                }
            }
        }
    }
}