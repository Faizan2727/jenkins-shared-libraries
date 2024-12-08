def call(String credID, String ImageName, String ImageTag) {
    withCredentials([usernamePassword(
                        credentialsId: credID,
                        usernameVariable: "dockerHubUser", 
                        passwordVariable: "dockerHubPass")]) {
        // Logging in to DockerHub
        sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
        
        // Tagging the Docker image
        sh "docker image tag ${ImageName}:${ImageTag} ${dockerHubUser}/${ImageName}:${ImageTag}"
        
        // Pushing the Docker image to DockerHub
        sh "docker push ${dockerHubUser}/${ImageName}:${ImageTag}"
    }
}
