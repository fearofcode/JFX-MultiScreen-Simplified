JFX-MultiScreen
===============

Original code: https://github.com/acaicedo/JFX-MultiScreen

This repo does the following:

- Replaces string references with classes for better safety
- Removes animation for simplicity
- General cleanup to make code smaller
- Renamed classes for clarity

The original code was fine, I just think this shows the idea more clearly.

<a href="https://github.com/fearofcode/JFX-MultiScreen-Simplified/blob/master/ScreensFramework/src/screensframework/ScreenSwitchingDemo.java">ScreenSwitchingDemo</a> has the main application.

<a href="https://github.com/fearofcode/JFX-MultiScreen-Simplified/blob/master/ScreensFramework/src/screensframework/ScreenSwitcher.java">ScreenSwitcher</a> maintains a `HashMap` of `Class`es to `Node`s.

To change the screen, nodes get pushed and popped off the view stack.

LICENSE
======

GPL. See modified header files.