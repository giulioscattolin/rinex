# rinex
A Java library that facilitates the reading and processing of RINEX data.
* Parse GPS navigation message files
* Query headers and records, for example [RinexGpsNavigationData](src/main/java/com/github/giulioscattolin/rinex/RinexGpsNavigationData.java)

![CI badge](https://github.com/giulioscattolin/rinex/actions/workflows/gradle.yml/badge.svg)
![JitPack badge](https://jitpack.io/v/giulioscattolin/rinex.svg)
[![Javadoc badge](https://img.shields.io/badge/Javadoc-1.0.0--alpha.3-brightgreen)](https://javadoc.jitpack.io/com/github/giulioscattolin/rinex/1.0.0-alpha.3/javadoc/)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)

## Installation

### Gradle (Groovy)
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    implementation 'com.github.giulioscattolin:rinex:1.0.0-alpha.3'
}
```