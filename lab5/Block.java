package Lab5;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * This class stores a single block of the blockchain
 * Original code from Marquette University
 * 	K. Lejmbach and D. Perouli,
 * “Developing a Modular and Interactive Blockchain Learning Tool for Undergraduate Computer Science Programs,” 
 * in Proceedings of the 54th ACM Technical Symposium on Computer Science Education V. 2, 
 * Toronto ON Canada: ACM, Mar. 2022, pp. 1324–1324. doi: 10.1145/3545947.3576271.
 * K. Lejmbach, D. Perouli, and M. Magiera, 
 * “Embedding Blockchain Concepts into Common Computer Science Courses,” 
 * in 2024 IEEE Frontiers in Education Conference (FIE), Washington, DC, USA:
 *  IEEE, Oct. 2024, pp. 1–5. doi: 10.1109/FIE61694.2024.10893052.
 *  
 *  @version September 2025, 
 *  Sherri Weitl-Harms
 *  Creighton University
 */
public class Block {
    private Block next;
    private String HashOfPreviousBlock;
    private String Contents;

    public Block(String newContents){
        this.Contents = newContents;
    }

    /**
     * Generates a hash of the Block to populate the HashOfPrevious block attribute
     * @return String representation of the SHA-256 encryption of the object
     */
    public String BlockHash(){
        try{
            String blockSummary = next.toString() + HashOfPreviousBlock + Contents;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //MessageDigest digest = MessageDigest.getInstance("SHA-512");
            byte[] StringBytes = digest.digest(blockSummary.getBytes());
            //006fe2cdcd9ef51722aec6958c0513abe1a00524058039201e9793a95f23bf18f9ec12001e46dca08ae50648616cb4b58c1c816fe9c6bec713af24ca3a8947da
            
            
            StringBuilder sb = new StringBuilder();
            for(byte StringByte: StringBytes){
                String hexValue = Integer.toHexString(0xff & StringByte);
                if(hexValue.length() == 1){
                    sb.append('0');
                }
                sb.append(hexValue);
            }
            return sb.toString();
        }
        catch (NoSuchAlgorithmException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Block getNext() {
        return next;
    }

    public void setNext(Block next) {
        this.next = next;
    }

    public String getHashOfPreviousBlock() {
        return HashOfPreviousBlock;
    }

    public void setHashOfPreviousBlock(String hashOfPreviousBlock) {
        HashOfPreviousBlock = hashOfPreviousBlock;
    }

    public String getContents() {
        return Contents;
    }

    public void setContents(String contents) {
        Contents = contents;
    }
}
