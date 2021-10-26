# rinex
A Java library that facilitates the reading and processing of RINEX data.
* Emits GPS navigation messages

![CI badge](https://github.com/giulioscattolin/rinex/actions/workflows/gradle.yml/badge.svg)
![JitPack badge](https://jitpack.io/v/giulioscattolin/rinex.svg)
[![Javadoc badge](https://img.shields.io/badge/Javadoc-1.0.0--alpha.5-brightgreen)](https://javadoc.jitpack.io/com/github/giulioscattolin/rinex/1.0.0-alpha.5/javadoc/)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)

## Installation

### Gradle (Groovy)
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.giulioscattolin:rinex:1.0.0-alpha.5'
}
```

### Usage
The [demo](/src/demo/java/com/github/giulioscattolin/rinex/demo) directory shows how to use this library write a simple CLI application that analyzes a RINEX file reporting any lexical and semantic error, and parsed data.

```shell
./gradlew analyzeRinexFile --args <path>
```
This will compile and run the application each time it is invoked. Feel free to experiment with it!

### Example output
```text
Found 175 RINEX data:
 - GPS navigation message: 175
Found no semantic errors!
Found 7 lexical errors:
 - At line 3, while reading headers: unknown header "IONOSPHERIC CORR"
 - At line 4, while reading headers: unknown header "IONOSPHERIC CORR"
 - At line 5, while reading headers: unknown header "COMMENT"
 - At line 6, while reading headers: unknown header "COMMENT"
 - At line 7, while reading headers: unknown header "COMMENT"
 - At line 8, while reading headers: unknown header "COMMENT"
 - At line 9, while reading headers: unknown header "COMMENT"
```