# Vaadin Chart.js [![Bintray](https://img.shields.io/bintray/v/moberwasserlechner/maven/vaadin-chartjs.svg)](https://bintray.com/moberwasserlechner/maven/vaadin-chartjs/_latestVersion) [![PayPal](https://img.shields.io/badge/%24-donate-0CB3EB.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=N8VS2P9233NJQ) [![License](https://img.shields.io/badge/license-MIT-B34ED4.svg)](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/LICENSE)

Vaadin 7 wrapper for the Chart.js charting library. https://github.com/chartjs/Chart.js

## Features

* Fluent api to configure the charts
* Supported chart types are
 * Horizontal bar chart
 * Vertical bar chart
 * Line chart
 * Donut chart
 * Pie chart
 * Polar area chart
 * Bubble chart
 * Radar chart
 * Scatter line chart
* Data point click listener

## Demo

### Vaadin Addon

* http://moberwasserlechner.jelastic.servint.net/vaadin-chartjs/

If you want to run the demo application locally, see the [Contribution Section](#run-the-demo-local)

### Chart.js

Afaik there are no online examples yet but you can download them along with the release distribution

* https://github.com/chartjs/Chart.js/releases/latest

## Installation

### Download

[![Bintray](https://img.shields.io/bintray/v/moberwasserlechner/maven/vaadin-chartjs.svg)](https://bintray.com/moberwasserlechner/maven/vaadin-chartjs/_latestVersion)

### Vaadin Directory

Get the addon from 
https://vaadin.com/directory#!addon/chartjs-add-on.

You can download the addon there as well, but you will need to create a free vaadin account first. For Maven style dependencies please use below settings.

### Maven

Repository

    <repositories>
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
      <dependency>
        <groupId>com.byteowls</groupId>
        <artifactId>vaadin-chartjs</artifactId>
        <version>0.3.0</version>
      </dependency>
    </dependencies>


### Gradle

Repository

    repositories {
      jcenter()
    }
     
Dependency

    dependencies {
      compile ("com.byteowls:vaadin-chartjs:0.3.0")
    }
## Usage

The basic usage is always the same. You need to create a new ChartJs() and configure it with a chart type specific config.

For more examples please see the demo app at http://moberwasserlechner.jelastic.servint.net/vaadin-chartjs/

```
        ChartJs myChart = new ChartJs(config);
        // enable logging to the javascript console. You can see some interessenting things there ;). Please do not use this in production because it's only needed for debugging.
        myChart.setJsLoggingEnabled(true);
        myChart.setWidth(50, Unit.PERCENTAGE);
        // add a data point clicklistener
        myChart.addClickListener((datasetIdx, dataIdx) -> {
            BarDataset dataset = (BarDataset) barConfig.data().getDatasets().get(datasetIdx);
            Notification.show("BarDataset at idx:" + datasetIdx + "; Data: idx=" + dataIdx + "; Value=" + dataset.getData().get(dataIdx), Type.WARNING_MESSAGE);
        });
```

### Bar chart configuration

In this example we configure a horizontal bar chart with 3 dataset and add some random numbers to each of them.

```java
        
        BarChartConfig config = new BarChartConfig();
        config
            .data()
                .labels("January", "February", "March", "April", "May", "June", "July")
                .addDataset(new BarDataset().type().label("Dataset 1").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
                .addDataset(new LineDataset().type().label("Dataset 2").backgroundColor("rgba(151,187,205,0.5)").borderColor("white").borderWidth(2))
                .addDataset(new BarDataset().type().label("Dataset 3").backgroundColor("rgba(220,220,220,0.5)"))
                .and();
        
        config.
            options()
                .responsive(true)
                .title()
                    .display(true)
                    .position(Position.LEFT)
                    .text("Chart.js Combo Bar Line Chart")
                    .and()
               .done();
        
        List<String> labels = config.data().getLabels();
        for (Dataset<?, ?> ds : config.data().getDatasets()) {
            List<Double> data = new ArrayList<>();
            for (int i = 0; i < labels.size(); i++) {
                data.add((double) (Math.random() > 0.5 ? 1.0 : -1.0) * Math.round(Math.random() * 100));
            }
            
            if (ds instanceof BarDataset) {
                BarDataset bds = (BarDataset) ds;
                bds.dataAsList(data);    
            }
                
            if (ds instanceof LineDataset) {
                LineDataset lds = (LineDataset) ds;
                lds.dataAsList(data);    
            }
        }
        
        ChartJs chart = new ChartJs(config);
        chart.setJsLoggingEnabled(true);

        return chart; 
```

### Chart Options

Please have a look at the great documentation at ChartJs. (http://www.chartjs.org/docs)

You will see that every fluent api method under `config.options()` has a counterpart in the javascript json config.  

## Prerequisite

### Addon
* JDK 7 or higher
* Vaadin 7.4 or higher

### Demo
* JDK 8 (because of Lambdas)
* Vaadin 7.7.0+


## Missing something?

The Vaadin-Chartjs is only a wrapper. So if you have any feature requests or found any bugs in the javascript lib please use Chart.js's issue tracker https://github.com/chartjs/Chart.js/issues

In all other cases please create a issue at https://github.com/moberwasserlechner/vaadin-chartjs/issues or contribute to the project yourself. For contribution see the next section.

## Contribute

### Setup Eclipse

1. Fork repo
2. Open command line
3. Clone your fork `git@github.com:USERNAME/vaadin-chartjs.git`
4. `cd vaadin-chartjs`
5. Build eclipse meta data `./gradlew cleanEclipse eclipse`
6. Open Eclipse
7. File -> Import... -> General -> Existing Projects into Workspace
8. Browse to your git repository
9. Check the option "Search for nested projects"
10. Check all 3 projects
11. Press finish

This should take not more than 1-2 minutes. You does not need to use any gradle eclipse plugins. 

### Fix a bug or create a new feature

Please do not mix more than one issue in a feature branch. Each feature/bugfix should have its own branch and its own Pull Request (PR).

1. Create a issue and describe what you want to do at [Issue Tracker](https://github.com/moberwasserlechner/vaadin-chartjs/issues)
2. Create your feature branch (`git checkout -b feature/my-feature` or `git checkout -b bugfix/my-bugfix`)
3. Test your changes to the best of your ability.
4. Add a demo view to the demo application 
5. Commit your changes (`git commit -m 'Describe feature or bug'`)
6. Push to the branch (`git push origin feature/my-feature`)
7. Create a Github Pull Request

### Run the demo local

The demo application is based on Spring Boot. So its possible to run the Demo as Java Application right out of Eclipse, there is not servlet container needed as Spring Boot has a embedded Tomcat 8 included.

1. Open "Debug Configurations..." dialog
2. Create a new "Java Application"
3. Choose the "vaadin-chartjs-demo" project
4. Use "com.byteowls.vaadin.chartjs.demo.ChartJsDemoApplication" as Main class
5. Set `-Dprofile=dev` as VM argument. This ensures that source code panel in the demo is correctly filled while developing.

### Code Style

Please use the sun coding convention. Please do not use tabs at all!

## License

MIT. Please see [LICENSE](https://github.com/moberwasserlechner/vaadin-chartjs/blob/master/LICENSE).

## Change Log

Please see [Releases](https://github.com/moberwasserlechner/vaadin-chartjs/releases).