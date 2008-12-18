require 'buildr/scala'
# Generated by Buildr 1.3.3, change to your liking
# Version number for this release
VERSION_NUMBER = "1.0.0"
# Group identifier for your projects
GROUP = "jambda"
COPYRIGHT = "(c) Agical AB 2008"

# Specify Maven 2.0 remote repositories here, like this:
repositories.remote << "http://www.ibiblio.org/maven2/"
repositories.remote << "http://www.agical.com/maven2/"

BUMBLEBEE  = ['com.agical.bumblebee:bumblebee-all:jar:1.0.2']

desc "The jambda project"
define "jambda" do

  project.version = VERSION_NUMBER
  project.group = GROUP
  manifest["Implementation-Vendor"] = COPYRIGHT

  define "com.agical.jambda" do
    compile.with # Add classpath dependencies
    package(:jar)
  end

  desc "jambda scala bridge"
  define "com.agical.jambda.scala" do
    manifest["Implementation-Vendor"] = COPYRIGHT
    compile.with project('com.agical.jambda')
    package :jar
  end

  desc "jambda documentation"
  define "com.agical.jambda.demo" do
    manifest["Implementation-Vendor"] = COPYRIGHT
    compile.with project('com.agical.jambda')
    compile.with BUMBLEBEE
    package :jar
  end

end
