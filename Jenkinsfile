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
    }
}