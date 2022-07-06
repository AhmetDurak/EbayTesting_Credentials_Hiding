def addCredentials(){
    withCredentials([usernamePassword(credentialsId: 'JenkinsCredentialGlobal', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
    echo "username: ${USER}"
    echo "password: ${PASS}"
  }
}

return this
