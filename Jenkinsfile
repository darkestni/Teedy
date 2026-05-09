pipeline {
    agent any
    stages {
        stage('Clean') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn clean'
            }
        }
        stage('Compile') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn compile'
            }
        }
        stage('Test') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn test -Dmaven.test.failure.ignore=true'
            }
        }
        stage('PMD') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn pmd:pmd'
            }
        }
        stage('JaCoCo') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn jacoco:report'
            }
        }
        stage('Javadoc') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn javadoc:javadoc'
            }
        }
        stage('Site') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn site'
            }
        }
        stage('Package') {
            steps {
                sh 'export JAVA_HOME=/Users/darkestbleeding/miniforge3/envs/jenkins-env/lib/jvm && export PATH=$JAVA_HOME/bin:$PATH && mvn package -DskipTests'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/site/**/*.*', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.jar', fingerprint: true
            archiveArtifacts artifacts: '**/target/**/*.war', fingerprint: true
            junit '**/target/surefire-reports/*.xml'
        }
    }
}
