Reproducing select 2 in modal window wicket issue
=================================================

https://github.com/wicketstuff/core/issues/470


Running and Reproducing:
------------------------
- run `mvn jetty:run`
- open `http://localhost:8080/` in browser
- click `Show modal dialog with a panel` link
- see a Modal Window with Select2 element
- click Select2 element - the list of options is not visible (is actually under the Modal)
- close the modal - the list of options remains visible
