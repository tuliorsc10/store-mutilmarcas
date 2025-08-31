pipeline {
    agent any

    environment {
        JWT_PUBLIC_KEY = credentials('jwt.public.key')
        JWT_PRIVATE_KEY = credentials('jwt.private.key')
    }

    tools {
        maven 'M3'
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
                sh 'mvn clean compile -Dspring.profiles.active=test'
            }
        }

        stage('Test') {
            steps {
                echo '🧪 Executando testes com H2...'
                sh 'mvn test -Dspring.profiles.active=test'
            }
        }

        stage('Package') {
            steps {
                echo '📦 Gerando pacote...'
                sh 'mvn package -DskipTests -Dspring.profiles.active=prod'
            }
        }

        stage('Code Coverage') {
            steps {
                echo '📊 Gerando relatório de cobertura...'
                // Gera relatório JaCoCo
                jacoco(
                    execPattern: '**/target/*.exec',
                    classPattern: '**/target/classes',
                    sourcePattern: '**/src/main/java',
                    exclusionPattern: '**/target/generated-sources/**'
                )
            }
        }
    }

    post {
        always {
            echo '✅ Publicando relatórios...'
            // Publica relatórios de testes
            junit '**/target/surefire-reports/*.xml'

            // Publica relatório JaCoCo HTML
            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'target/site/jacoco',
                reportFiles: 'index.html',
                reportName: 'JaCoCo Coverage Report'
            ])

            // Limpeza opcional
            sh 'echo "Build completed with status: $currentBuild.result"'
        }

        success {
            echo '🎉 Build realizado com sucesso!'
        }

        failure {
            echo '❌ Build falhou!'
        }
    }
}