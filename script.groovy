def buildJar() {
    echo "building the application..."
    //sh 'mvn clean'
    sh 'mvn compile'
    sh 'mvn test'
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'new-docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t zerqqaoui/text_to_binary_java_maven:jma-1.1 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push zerqqaoui/text_to_binary_java_maven:jma-1.1'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
