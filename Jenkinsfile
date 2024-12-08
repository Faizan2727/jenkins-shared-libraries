@Library('Shared')_
pipeline {
    agent { label "dev-server" }
    stages {
        stage("Code Clone") {
            steps {
                script {
                    clone("https://github.com/LondheShubham153/node-todo-cicd.git", "master")
                }
            }
        }
        stage("Code Build & Test") {
            steps {
                script {
                    dockerbuild("notes-app", "latest")
                }
            }
        }
        stage("Push to Docker Hub") {
            steps {
                script {
                    docker_push("dockerhubCreds", "notes-app", "latest")
                }
            }
        }
        stage("Deploy") {
            steps {
                script {
                    deploy()
                }
            }
        }
    }
}
