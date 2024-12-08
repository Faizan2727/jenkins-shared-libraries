def call(String Project, String ImageTag, String dockerhubuser){
  withCredentials([usernamePassword(
      credentialsId: 'dockerhubCreds', 
      passwordVariable: 'dockerHubPass', 
      usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerhubuser} --password-stdin ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
