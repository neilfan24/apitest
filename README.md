# apitest
注意事项：pom的maven配置
               <configuration>
                    <!--<skipTests>true</skipTests>-->
                    <testFailureIgnore>true</testFailureIgnore>
                    <suiteXmlFiles>
                        <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
                    </suiteXmlFiles>
                    <systemProperties>
                        <property>
                            <name>allure.results.directory</name>
                            <!--<value>./target/allure-results</value>-->
                            为了解决jenkins构建项目时，报allure-results文件夹不存在，所以手动现在jenkins的workspace目录下建allure-results文件夹，然后指定生成到该目录下
                            <value>C:\Windows\System32\config\systemprofile\AppData\Local\Jenkins\.jenkins\workspace\apitest\allure-results</value>
                        </property>
                    </systemProperties>
                    <argLine>
                        -javaagent:"D:\maven_local_repository/org/aspectj/aspectjweaver/1.9.5/aspectjweaver-1.9.5.jar"
                    </argLine>
                </configuration>
                
                
jenkins全局配置：Allure Commandline的安装目录路径为：D:\allure-2.13.8，千万不要加\bin         
