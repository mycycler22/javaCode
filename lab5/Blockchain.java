package Lab5;

/**
 * This class stores the list of blocks for the blockchain
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

public class Blockchain {
    private Block root;

    public Blockchain(Block NewRoot){
        this.root = NewRoot;
    }

    /**
     * Appends to the end of the blockchain the next block.
     * The code also sets the HashOfThePreviousBlock attribute based on the preceding block's attributes.
     * @param next block to be appended to the end of the blockchain.
     */
    public void append(Block next){
        Block end = root;
        while(end.getNext() != null){
            end = end.getNext();
        }
        end.setNext(next);
        next.setHashOfPreviousBlock(end.BlockHash());
    }

    /**
     *
     * @return last block in the blockchain
     */
    public Block last(){
        Block end = root;
        while(end.getNext() != null){
            end = end.getNext();
        }
        return end;
    }

    /**
     * Generates a string representation of the current state of the blockchain
     * @return String containing all the blocks present in the blockchain.
     */
    public String printChain(){
        Block end = root;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(end.getNext() != null){
            sb.append((index+", "));
            sb.append((end.getNext()+", "));
            sb.append((end.getContents()+", "));
            sb.append((end.getHashOfPreviousBlock()+"\n"));
            end = end.getNext();
        }
        return sb.toString();
    }

    public String printChainVerbose(){
        Block end = root;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(end != null){
            sb.append(("index: "+index+"\n"));
            sb.append(("next block memory pointer: "+end.getNext()+"\n"));
            sb.append(("contents of this block (3 arrays: books in library, patrons in library, librarians in library): "+end.getContents()+"\n"));
            sb.append(("Hash of previous block: "+end.getHashOfPreviousBlock()+"\n"));
            end = end.getNext();
            index += 1;
        }
        return sb.toString();
    }

    /**
     * Updates the contents of a block at a specific index. The code also updates the hashes of the next blocks.
     * This reflects the changes in hashes of all blocks that appear after the altered block.
     * @param index place where the new contents should be added
     * @param contents contents that will replace the old.
     */
    public void editContentsAtIndex(int index, String contents){
        Block blockToEdit = root;
        while(blockToEdit.getNext() != null && index > 0){
            blockToEdit = blockToEdit.getNext();
            index -= 1;
        }
        blockToEdit.setContents(contents);
        while(blockToEdit.getNext() != null){
            Block next = blockToEdit.getNext();
            next.setHashOfPreviousBlock(blockToEdit.BlockHash());
            blockToEdit = next;
        }
    }

    public Block getRoot(){
        return root;
    }
}
