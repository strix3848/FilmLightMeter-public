#!/bin/sh
set -eu
example_dir=$(dirname "$0")
example_build_dir=$(mktemp -d)
trap 'rm -rf "$example_build_dir"' EXIT HUP INT TERM
javac -encoding UTF-8 -d "$example_build_dir" \
  "$example_dir/src/com/filmmeter/app/IsoEiSettings.java" \
  "$example_dir/src/com/filmmeter/app/FrameFormats.java" \
  "$example_dir/demo/com/filmmeter/app/ExampleRunner.java"
java -cp "$example_build_dir" com.filmmeter.app.ExampleRunner
