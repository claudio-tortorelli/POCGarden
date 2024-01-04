# POCGarden
Il giardino dei ProofOfConcept

## Description
POCGarden is an almost all purposes Java Maven environment that I use to develop POCs as sub-projects/sub-modules.
The idea is to share some common and usefull basic features between POCs, where a POC is intended as a command line tool, that uses a minimal set of external dependencies to implement a concept.
Sharing most common utilities and plugins the POC development should be improved, focusing on the main idea to be verified.

## Structure
The garden is composed by
- main project POM: POCGarden
- a sub project as shared utility library: POCBase
- another sub multi module project that is the container of the POCs: POCSoil

POCBase is a dependency of POCSoil, and POCSoil is the parent POM of each POC, where are defined common plugins and deps.
Moreover POCSoil defines which profiles must be built. 

## Building projects
Executing a mvn clean install on POCGarden all sub project is built. But the POCSoil project build will fail if any submodule folder isn't present.
Into POCSoil's POM are defined modules that must be downloaded from a separate repository as subfolders.

example:
```
...
    <modules>
        <!-- HERE ENABLE POC MODULES YOU WANT TO BUILD -->
        <!-- EACH MODULE MUST BE PRESENT IN A SUBFOLDER -->
        <module>ReadableOTP</module>
        <module>Deck</module>
    </modules>
...
```
You need to comment or remove any module entry that you won't build.

