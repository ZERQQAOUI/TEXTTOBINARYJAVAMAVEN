def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'new-docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t zerqqaoui/text_to_binary_java_maven:jma-1.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker zerqqaoui/text_to_binary_java_maven:jma-1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
