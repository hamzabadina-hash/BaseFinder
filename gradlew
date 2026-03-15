#!/bin/sh
APP_HOME=$(cd "$(dirname "$0")" && pwd)
GRADLE_HOME=$APP_HOME/gradle/wrapper
exec java -classpath "$GRADLE_HOME/gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain "$@"
