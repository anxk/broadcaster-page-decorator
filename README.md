# Broadcaster Page Decorator Plugin

[![Build Status](https://www.travis-ci.org/anxk/broadcaster-page-decorator-plugin.svg?branch=master)](https://www.travis-ci.org/anxk/broadcaster-page-decorator-plugin)

This plugin can decorate all pages of Jenkins with your customized message, as shown below:

<p align="center">
	<img src="images/view-example.png" alt="view-example.png"  width=90% height=90%>
	<p align="center">
		<em>View Example</em>
	</p>
</p>

## Installation

Clone this repo on your disk, navigate into folder `broadcaster-page-decorator-plugin` and run command `mvn verify`, when it completed, upload `target/broadcaster-page-decorator.hpi` to the update center of Jenkins and install it.

Also you can download `broadcaster-page-decorator.hpi` from [release page](https://github.com/anxk/broadcaster-page-decorator-plugin/releases), then upload it to the update center of Jenkins.

## Configuration

Go to manage > configure > Broadcaster Page Decorator Plugin, just pust what you want to broadcast in the `Message textarea`, for example (the font color and background can be modified if needed):

<p align="center">
	<img src="images/configuration-example.png" alt="configuration-example.png"  width=90% height=90%>
	<p align="center">
		<em>Configuration Example</em>
	</p>
</p>
