This is the result from Basic Java Algorithms. In complex we added basic PEMDAS construcors. In CalculatorApp file, i used javas library to use swing. 
Imports: These lines import necessary packages.
javax.swing.*: This imports all the classes from the Swing package, which is used for building graphical user interfaces (GUIs) in Java.
java.awt.*: This imports all the classes from the Abstract Window Toolkit (AWT) package, which provides the classes for the GUI components.
java.awt.event.*: This imports all the event classes from the AWT package, which are used to handle events like button clicks.

JFrame is a class in the Swing package that represents a window with decorations such as a title, border, and buttons for closing or resizing the window.

displayField: A JTextField to display the current input or result.
buttonPanel: A JPanel to hold the calculator buttons.
currentInput, storedInput, currentOperation: Strings to store the current input, the stored input, and the current operation respectively.

setTitle("Complex Calculator"): Sets the title of the window to "Complex Calculator".
setSize(300, 400): Sets the size of the window to 300 pixels wide and 400 pixels tall.
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE): Specifies that the application should exit when the window is closed.
setLayout(new BorderLayout()): Sets the layout manager to BorderLayout, which arranges components in five regions: north, south, east, west, and center.

new JTextField(): Creates a new text field.
setEditable(false): Makes the text field non-editable by the user.
setHorizontalAlignment(JTextField.RIGHT): Aligns the text to the right.
setFont(new Font("Arial", Font.PLAIN, 24)): Sets the font to Arial, plain style, size 24.
add(displayField, BorderLayout.NORTH): Adds the text field to the north region of the BorderLayout.

new JPanel(new GridLayout(5, 4, 5, 5)): Creates a new panel with a 5x4 grid layout, where each cell has a horizontal and vertical gap of 5 pixels.
add(buttonPanel, BorderLayout.CENTER): Adds the panel to the center region of the BorderLayout.

