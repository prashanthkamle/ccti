package interview.ccti.arrays;

/**
 * Question 1.3
 * @author prashanth
 *
 */
public class URLify {
	
	public static void main(String[] args) {
		char[] s = new char[20];
		s[0] = 'a';	s[1] = ' '; s[2] = 'b'; s[3] = 'c'; s[4] = ' '; s[5] = 'd'; s[6] = '\0';
		
		int len = 0;
		int spaces = 0;
		while(s[len] != '\0') {
			len++;
			if(s[len] == ' ') {
				spaces++;
			}		
		}
				
		while(len >= 0) {
			char c = s[len];
			int posn = len + 2*spaces;
			if(c == ' ') {				
				s[posn--] = '0';
				s[posn--] = '2';
				s[posn--] = '%';
				spaces--;
			} else {
				s[posn] = s[len]; 
			}
			
			len--;
		}
		
		len = 0;
		while(s[len] != '\0') {
			System.out.print(s[len]);
			len++;
		}
	}
	
}
