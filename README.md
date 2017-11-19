
# color-depth

Easy color translations. Currently acting as surface area into the rich pool of color-related functions in the [Google Closure Library](https://google.github.io/closure-library/api/goog.color.html).

![colors](https://user-images.githubusercontent.com/1638576/32996136-60306532-cd44-11e7-99d9-e9a734d81989.gif)

### Development mode

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.


### Building for production

```
lein clean
lein package
```
