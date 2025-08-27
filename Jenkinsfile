pipeline {
    agent any

    tools {
        // Configura automaticamente Maven
        maven 'M3'  // 'M3' é o nome da ferramenta configurada no Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                echo '📦 Fazendo checkout do código...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '🔨 Compilando projeto Maven...'
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Executando testes...'
                sh 'mvn test'
            }

            post {
                always {
                    // Publicar relatórios de teste mesmo se falhar
                    junit '**/target/surefire-reports/*.xml'
                }
            }
        }
    }
}