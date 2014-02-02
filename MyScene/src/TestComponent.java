/**
 * This is a test harness for simple graphic classes.
 *
 * @author Dan Jinguji
 * @version 0.2
 */
public class TestComponent {
    /**
     * Constructor for the harness
     *
     * @param comp The component to be tested
     */
    public TestComponent(java.awt.Component comp) {
        // create a window
        javax.swing.JFrame win;
        win = new javax.swing.JFrame("Test the Component");
        win.setLocation(10, 10);
        win.setSize(10, 10);

        // add the traffic light to the window
        win.add(comp);
        win.add(new VSpacer(), java.awt.BorderLayout.NORTH);
        win.add(new VSpacer(), java.awt.BorderLayout.SOUTH);
        win.add(new HSpacer(), java.awt.BorderLayout.EAST);
        win.add(new HSpacer(), java.awt.BorderLayout.WEST);

        // some "magic" code to check for the margin
        comp.setPreferredSize(comp.getSize());
        win.pack();

        // make the window visible
        win.setVisible(true);
    }
    private class HSpacer extends java.awt.Panel {
        public HSpacer() {
            setPreferredSize(new java.awt.Dimension(75, 0));
            setBackground(java.awt.Color.gray);
        }
    }
    private class VSpacer extends java.awt.Panel {
        public VSpacer() {
            setPreferredSize(new java.awt.Dimension(0, 75));
            setBackground(java.awt.Color.gray);
        }
    }

    public static void main(String[] args)
    {
        new TestComponent(new MyTree(0,0));
    }
}