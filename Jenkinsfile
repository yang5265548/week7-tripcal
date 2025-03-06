pipeline{
    agent any
    environment {
            // Define Docker Hub credentials ID
            DOCKERHUB_CREDENTIALS_ID = 'dockerhub-credentials'
            // Define Docker Hub repository name
            DOCKERHUB_REPO = 'yangyang5265548/week7_inclass_trip'
            // Define Docker image tag
            DOCKER_IMAGE_TAG = 'latest_v1'
        }
    stages{
      stage('checking'){
        steps{
          git branch:'main',url:'https://github.com/yang5265548/week7-tripcal.git'
        }
      }
      stage('build'){
        steps{
          bat 'mvn clean install'
        }
      }
        stage('Test & coverage'){
            steps{
                bat 'mvn clean install'
            }
            post{
                always{
                    junit 'target/surefire-reports/*.xml'
                    jacoco execPattern:'**/target/jacoco.exec',
                        classPattern:'**/target/classes',
                        sourcePattern:'**/src/main/java',
                        exclusionPattern:'**/test/**'
                }
            }
        }
        stage('Docker Debug Info') {
                    steps {
                        script {
                            echo '===== Docker Version (Windows) ====='
                            bat 'docker version'
                            echo '===== Docker Info (Windows) ====='
                            bat 'docker info'
                        }
                    }
                }
                    stage('List Credentials') {
                            steps {
                                script {
                                    def credentialsStore = Jenkins.instance.getExtensionList('com.cloudbees.plugins.credentials.SystemCredentialsProvider')[0]
                                    def credentials = credentialsStore.getStore(Jenkins.instance).getCredentials(com.cloudbees.plugins.credentials.CredentialsScope.GLOBAL)
                                    credentials.each { cred ->
                                        println("Credential ID: ${cred.id}  Type: ${cred.getClass()}")
                                    }
                                }
                            }
                        }
                 stage('Build Docker Image') {
                            steps {
                                // Build Docker image
                                script {
                                    docker.build("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}")
                                }
                            }
                        }
                        stage('Push Docker Image to Docker Hub') {
                            steps {
                                // Push Docker image to Docker Hub
                                script {
                                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS_ID) {
                                        docker.image("${DOCKERHUB_REPO}:${DOCKER_IMAGE_TAG}").push()
                                    }
                                }
                            }
                        }
    }
}
