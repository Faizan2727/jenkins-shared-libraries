def call(String credID, String ImageName, String ImageTag){
  withCredentials([usernamePassword(
                    credentialsId:credID,
                    usernameVariable:"dockerHubUser", 
                    passwordVariable:"dockerHubPass")]){
                sh 'echo $dockerHubPass | docker login -u $dockerHubUser --password-stdin'
                sh "docker image tag ${ImageName}:${ImageTag} ${env.dockerHubUser}/${ImageName}:${ImageTag}
                sh "docker push ${env.dockerHubUser}/${ImageName}:${ImageTag}
  }
}
