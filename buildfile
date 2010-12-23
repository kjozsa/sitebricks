repositories.remote \
  << 'http://www.ibiblio.org/maven2' \
  << 'http://oss.sonatype.org/content/repositories/google-snapshots/'

desc '["sitebricks demo app"]'

define 'sitebricks' do
  project.version = "1.0.0"
  project.group = "com.ftl"
  manifest["Implementation-Vendor"] = "FTL Development"
  
  compile.options.target = '1.6'  
  compile.with \
    'ch.qos.logback:logback-classic:jar:0.9.17', \
    'ch.qos.logback:logback-core:jar:0.9.17', \
    'javax.ejb:ejb-api:jar:3.0', \
    'org.slf4j:slf4j-api:jar:1.5.8', \
    'org.slf4j:slf4j-api:jar:1.5.8', \
    'com.db4o:db4o-java5:jar:7.4.106-13438', \
    'com.google.sitebricks:sitebricks:jar:0.8-SNAPSHOT', \
    'com.google.inject:guice:jar:2.0', \
    'com.google.inject.extensions:guice-servlet:jar:2.0', \
    'javax.servlet:servlet-api:jar:2.5'

  package :war, :id => 'sitebricks'
end
