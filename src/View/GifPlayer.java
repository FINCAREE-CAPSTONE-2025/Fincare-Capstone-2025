//package View;
//
//import javax.imageio.*;
//import javax.imageio.metadata.IIOMetadata;
//import javax.imageio.metadata.IIOMetadataNode;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.image.BufferedImage;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import javax.imageio.stream.ImageInputStream;
//
//public final class GifPlayer {
//    private final JLabel target;
//    private final List<BufferedImage> frames = new ArrayList<>();
//    private final List<Integer> delaysMs = new ArrayList<>();
//    private Timer timer;
//    private int idx;
//
//    public GifPlayer(JLabel target) {
//        this.target = target;
//    }
//
//    public void loadFromResource(String path, int w, int h) {
//        try (InputStream is = GifPlayer.class.getResourceAsStream(path)) {
//            if (is == null) throw new IllegalArgumentException("Not found: " + path);
//
//            Iterator<ImageReader> it = ImageIO.getImageReadersByFormatName("gif");
//            ImageReader r = it.next();
//            ImageInputStream iis = ImageIO.createImageInputStream(is);
//            r.setInput(iis, false);
//
//            int num = r.getNumImages(true);
//            frames.clear(); 
//            delaysMs.clear();
//
//            for (int i = 0; i < num; i++) {
//                BufferedImage src = r.read(i);
//
//                BufferedImage scaled = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
//                Graphics2D g2 = scaled.createGraphics();
//                g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//                g2.drawImage(src, 0, 0, w, h, null);
//                g2.dispose();
//                frames.add(scaled);
//
//                IIOMetadata meta = r.getImageMetadata(i);
//                int delayMs = 80; // default ~12.5 fps
//                try {
//                    IIOMetadataNode root = (IIOMetadataNode) meta.getAsTree("javax_imageio_gif_image_1.0");
//                    IIOMetadataNode gce  = (IIOMetadataNode) root.getElementsByTagName("GraphicControlExtension").item(0);
//                    int cs = Integer.parseInt(gce.getAttribute("delayTime")); // centiseconds
//                    delayMs = Math.max(20, cs * 10);
//                } catch (Exception ignore) {}
//                delaysMs.add(delayMs);
//            }
//
//            // ========= DROP-FRAME OPTIMIZATION (tambahan) =========
//            if (frames.size() > 120) {
//                java.util.List<BufferedImage> f2 = new java.util.ArrayList<>();
//                java.util.List<Integer> d2 = new java.util.ArrayList<>();
//                for (int i = 0; i < frames.size(); i += 2) { // ambil tiap 2 frame
//                    f2.add(frames.get(i));
//                    int d = delaysMs.get(i);
//                    if (i + 1 < delaysMs.size()) d += delaysMs.get(i + 1); // gabung delay
//                    d2.add(d);
//                }
//                frames.clear(); frames.addAll(f2);
//                delaysMs.clear(); delaysMs.addAll(d2);
//            }
//            // ======================================================
//
//            r.dispose();
//
//            if (!frames.isEmpty()) {
//                target.setIcon(new ImageIcon(frames.get(0)));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void start() {
//        if (frames.isEmpty()) return;
//        stop();
//        idx = 0;
//        timer = new Timer(delaysMs.get(0), e -> {
//            idx = (idx + 1) % frames.size();
//            target.setIcon(new ImageIcon(frames.get(idx)));
//            ((Timer) e.getSource()).setDelay(delaysMs.get(idx));
//        });
//        timer.setCoalesce(true);
//        timer.start();
//    }
//
//    public void stop() {
//        if (timer != null) { timer.stop(); timer = null; }
//    }
//}
