
# color-depth

Easy color translations. Currently acting as surface area into the rich pool of color-related functions in the [Google Closure Library](https://google.github.io/closure-library/api/goog.color.html).


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
