# Vaadin Chart.js [![Bintray](https://img.shields.io/bintray/v/moberwasserlechner/maven/vaadin-chartjs.svg)](https://bintray.com/moberwasserlechner/maven/vaadin-chartjs/_latestVersion) [![PayPal](https://img.shields.io/badge/%24-paypal-f39c12.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=N8VS2P9233NJQ) [![License](https://img.shields.io/badge/license-MIT-orange.svg)](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/LICENSE)

Vaadin 7 wrapper for the Chart.js charting library. https://github.com/chartjs/Chart.js

## Features

* Chartjs component

## Installation

### Download

[![Bintray](https://img.shields.io/bintray/v/moberwasserlechner/maven/vaadin-chartjs.svg)](https://bintray.com/moberwasserlechner/maven/vaadin-chartjs/_latestVersion)

### Vaadin Directory

Get the addon from 
https://vaadin.com/directory#!addon/chartjs-wrapper.

Vaadin runs its own Maven repository and you can download the addon there as well, but you will need to create a free vaadin account first.

### Maven

Repository

    <repositories>
      <!-- ... other repository elements ... -->
      <repository>
        <snapshots>
          <enabled>false</enabled>
        </snapshots>
        <id>central</id>
        <name>bintray</name>
        <url>http://jcenter.bintray.com</url>
      </repository>
    </repositories>
    
Dependency

    <dependencies>
      <!-- ... other dependency elements ... -->
      <dependency>
        <groupId>com.byteowls</groupId>
        <artifactId>vaadin-chartjs</artifactId>
        <version>0.1.0</version>
      </dependency>
    </dependencies>


### Gradle

Repository

    repositories {
      jcenter()
    }
    // or 
    repositories {
      maven {
        url  "http://jcenter.bintray.com" 
      }
    }
     
Dependency

    dependencies {
      compile ("com.byteowls:vaadin-chartjs:0.1.0")
    }

## Prerequisite

### Addon
* JDK 7 or higher
* Vaadin 7.4 or higher

### Demo
* JDK 8 (because of Lambdas)
* Vaadin 7.4 or higher

## Usage


## Missing something?

The Vaadin-Chartjs is only a wrapper. So if you have any feature requests or found any bugs in the javascript lib please use Chart.js's issue tracker https://github.com/chartjs/Chart.js/issues

In all other cases please create a issue at https://github.com/moberwasserlechner/vaadin-chartjs/issues or contribute to the project yourself. For contribution see the next section.

## Contribute

1. Fork it
2. Create your feature branch (`git checkout -b my-feature-or-bug`)
3. Test your changes to the best of your ability.
5. Commit your changes (`git commit -am 'Describe feature or bug'`)
6. Push to the branch (`git push origin my-feature-or-bug`)
7. Create new Pull Request


### Eclipse

1. Build eclipse project configs for addon and demo with `./gradlew cleanEclipse eclipse`
2. In Eclipse open File->Import... and choose General->Existing Projects into Workspace for the root folder

### Code Style

Please use the sun coding convention with **4 spaces** instead of tabs for indention. Please do not use tabs at all!

## Demo

### Chart.js

Afaik there are no online examples yet but you can download them along with the release distribution

* https://github.com/chartjs/Chart.js/releases/latest

### Vaadin Chart.js

**Run it yourself**

1. Clone the repository
2. Run the embedded Tomcat by `./gradlew :demo:run`
3. It starts at `http://localhost:8080`

**Live Demo**

http://moberwasserlechner.jelastic.servint.net/vaadin-chartjs/

## License

MIT. Please see [LICENSE](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/LICENSE).

## Change Log

Please see [CHANGELOG](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/CHANGELOG.md).