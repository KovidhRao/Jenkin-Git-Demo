pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo '=== Stage 1: Checking out code from GitHub ==='
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo '=== Stage 2: Building project (mvn compile) ==='
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                echo '=== Stage 3: Running JUnit tests (mvn test) ==='
                bat 'mvn test'
            }
            post {
                always {
                    // Generates test report in Jenkins
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                }
            }
        }

        stage('Package') {
            steps {
                echo '=== Stage 4: Packaging application into JAR (mvn package) ==='
                bat 'mvn package -DskipTests'
                // Archive the generated JAR artifact so it appears on the Jenkins build page
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true, allowEmptyArchive: true
            }
        }
    }

    post {
        success {
            echo 'SUCCESS: CI Pipeline completed successfully! JAR artifact generated.'
        }
        failure {
            echo 'FAILURE: CI Pipeline encountered errors. Please check console output.'
        }
    }
}
