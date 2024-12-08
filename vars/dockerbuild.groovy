def call(String appName, String tag) {
    sh "docker build -t ${appName}:${tag} ."
}
