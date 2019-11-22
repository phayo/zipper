# Java Zipper

A simple program that writes data to a zip file

## Usage
Runs on the command line

## Details
- File names are passed as command line arguments.
- Saves the zip file to an archive named "data.zip".
- Saves the zip file in the current directory.
- Throws IOException

## Testing
Included is a MainTest class for testing the method. 3 files are in the
`setup()` method and deleted in the `tearDown()` method.

The test `zipTest()` simply checks that the data.zip file exits
