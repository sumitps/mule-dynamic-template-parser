# HTML Template Parser Extension
A mule connector that parses html templates by evaluating and replacing the contained dwl code in the html file

**Requires Java 1.8 to build**

Build and install extension using maven:
> mvn clean install

check the version of installed extension and use below snippet to add as dependency in mule project

Add this dependency to your application pom.xml

```
<groupId>org.mule.extension</groupId>
<artifactId>mule-html-template-parser</artifactId>
<version>{template.plugin.version}</version>
<classifier>mule-plugin</classifier>

```

