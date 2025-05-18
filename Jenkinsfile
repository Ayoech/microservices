pipeline {
    agent any

    environment {
        IMAGE_TAG = "latest"
    }

    stages {
        stage('Clone Repository') {
            steps {
                git 'https://github.com/Ayoech/microservices'
            }
        }

        stage('Build Docker Images') {
            steps {
                script {
                    def services = ['catalog', 'gateway', 'microservices', 'service']
                    services.each { svc ->
                        sh "docker build -t ${svc}:${IMAGE_TAG} ./${svc}"
                    }
                }
            }
        }

        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s-microservices/'
            }
        }
    }
}
