import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;

class Component {
    private String name;
    private double price;

    public Component(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class ElectronicsStoreApp extends JFrame implements ActionListener {
    JButton cpuButton, monitorButton, keyboardButton, LaptopButton, mouseMatButton, hdmiButton, finishButton, zfoldButton, s23UButton,Redmi5Button,iph15proButton,iph15Button,MBPROButton,MouseButton;
    JTextArea selectedComponentsArea;
    ArrayList<Component> selectedComponents;
    private ArrayList<Component> availableComponents;

    ElectronicsStoreApp() {
        setTitle("Electronics Store");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        selectedComponents = new ArrayList<>();
        availableComponents = new ArrayList<>();
        initializeAvailableComponents();

        JPanel componentsPanel = new JPanel();
        componentsPanel.setLayout(new GridLayout(4, 3));

        cpuButton = createButton("ASUS ROG Strix GA35",278990, "D:\\downloads\\ROG CPU.png",100,100);
        monitorButton = createButton("Samsung 49-inch(124.4cm) Odyssey OLED G9 Dual QHD, 240Hz, 0.03ms Curved Gaming Monitor, USB Hub, HAS, Neo Quantum Processor, Smart TV, AMD FreeSync Premium Pro",178999, "C:\\Users\\ganes\\Downloads\\Samsung-Odyssey-G9-front.png",250,100);
        keyboardButton = createButton("Razer Store USB Blackwidow Elite: Esports Gaming Keyboard",54413, "D:\\downloads\\KEYBOARD.png",100,100);
        LaptopButton = createButton("Mi NoteBook Ultra",69999, "C:\\Users\\ganes\\Downloads\\mi-notebook-ultra.png",180,100);
        mouseMatButton = createButton("RAZER FIREFLY CHROMA HARD: Micro-Textured Finish - Non-Slip Rubber Base - Powered by Razer Chroma",16495, "C:\\Users\\ganes\\Downloads\\mouse-mat.png",100,100);
        hdmiButton = createButton("HDMI Cable",599.99, "D:\\downloads\\HDMI.png",100,100);
        zfoldButton = createButton("Z Fold 5",164999, "D:\\downloads\\samsung-galaxy-z-fold-4.png",100,100);
        s23UButton = createButton("S23 Ultra",124999, "D:\\downloads\\s23u.png",100,100);
        Redmi5Button = createButton("Redmi 5",11000, "C:\\Users\\ganes\\Downloads\\redmi-5.png",130,100);
        iph15proButton = createButton("Iphone 15 pro max",194000, "D:\\downloads\\iphone-15-pro-max.png",100,100);
        iph15Button = createButton("Iphone 15",88000, "D:\\downloads\\iphone-15.png",100,100);
        MBPROButton = createButton("Apple MacBook Pro 2023",239900, "D:\\downloads\\302693_fxepji.png",100,100);
        MouseButton = createButton("Apple MacBook Pro 2023",239900, "D:\\downloads\\302693_fxepji.png",100,100);

        componentsPanel.add(cpuButton);
        componentsPanel.add(monitorButton);
        componentsPanel.add(keyboardButton);
        componentsPanel.add(LaptopButton);
        componentsPanel.add(mouseMatButton);
        componentsPanel.add(hdmiButton);
        componentsPanel.add(Redmi5Button);
        componentsPanel.add(zfoldButton);
        componentsPanel.add(s23UButton);
        componentsPanel.add(iph15proButton);
        componentsPanel.add(iph15Button);
        componentsPanel.add(MBPROButton);
        
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        selectedComponentsArea = new JTextArea();
        selectedComponentsArea.setEditable(false);
        selectedComponentsArea.setFont(new Font("Arial", Font.PLAIN, 18)); 

        
        selectedComponentsArea.setPreferredSize(new Dimension(400, 300));

        JScrollPane scrollPane = new JScrollPane(selectedComponentsArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        centerPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        finishButton = new JButton("Finish");
        finishButton.addActionListener(this);
        bottomPanel.add(finishButton);

        add(componentsPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        

        setVisible(true);
        finishButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displaySelectedComponents();
            }
        });
    }

    private JButton createButton(String componentName, double price, String imagePath, int width, int height) {
        JButton button = new JButton("<html><center>" + componentName + "<br><br>₹" + price + "</center></html>");
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            ImageIcon icon = new ImageIcon(originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH));
            button.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setActionCommand(componentName); 
        button.addActionListener(this);
        return button;
    }

    private void initializeAvailableComponents() {
        availableComponents.add(new Component("ASUS ROG Strix GA35", 278990));
        availableComponents.add(new Component("Samsung 49-inch(124.4cm) Odyssey OLED G9 Dual QHD, 240Hz, 0.03ms Curved Gaming Monitor, USB Hub, HAS, Neo Quantum Processor, Smart TV, AMD FreeSync Premium Pro", 178999));
        availableComponents.add(new Component("Razer Store USB Blackwidow Elite: Esports Gaming Keyboard", 54413));
        availableComponents.add(new Component("Mi NoteBook Ultra", 69999));
        availableComponents.add(new Component("RAZER FIREFLY CHROMA HARD: Micro-Textured Finish - Non-Slip Rubber Base - Powered by Razer Chroma", 16495));
        availableComponents.add(new Component("HDMI Cable", 14.99));
        availableComponents.add(new Component("Redmi 5", 11000));
        availableComponents.add(new Component("Z Fold 5", 164999));
        availableComponents.add(new Component("S23 Ultra", 124999));
        availableComponents.add(new Component("Iphone 15 pro max", 194000));
        availableComponents.add(new Component("Iphone 15", 88000));
        availableComponents.add(new Component("Apple MacBook Pro 2023", 239900));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton sourceButton = (JButton) e.getSource();
            addComponentToSelection(sourceButton.getActionCommand());
        }
    }
    

    private void addComponentToSelection(String selectedComponentName) {
        for (Component component : availableComponents) {
            if (component.getName().equals(selectedComponentName)) {
                selectedComponents.add(component);
                break;
            }
        }
        updateSelectedComponentsArea();
    }
    

    private void updateSelectedComponentsArea() {
        selectedComponentsArea.setText("");
        double totalPrice = 0.0;
        for (Component component : selectedComponents) {
            selectedComponentsArea.append(component.getName() + " - ₹" + component.getPrice() + "\n");
            totalPrice += component.getPrice();
        }
        selectedComponentsArea.append("\nTotal Price: ₹" + totalPrice);
    }

    
    private void displaySelectedComponents() {
        StringBuilder summary = new StringBuilder("Selected Components:\n");
        double totalPrice = 0.0;
        for (Component component : selectedComponents) {
            summary.append(component.getName()).append(" - ₹").append(component.getPrice()).append("\n");
            totalPrice += component.getPrice();
        }
        summary.append("\nTotal Price: ₹").append(totalPrice);

        JTextArea billDetails = new JTextArea(summary.toString());
        billDetails.setEditable(false);
        billDetails.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size here

        JScrollPane scrollPane = new JScrollPane(billDetails);
        JOptionPane.showMessageDialog(this, scrollPane, "Billing Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ElectronicsStoreApp());
    }
}

