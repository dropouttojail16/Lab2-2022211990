import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

public class SolutionTest extends TestCase {

    // 测试用例设计的总体原则：
    // 1. 等价类划分原则：根据输入字符串的长度和内容，将其划分为不同的等价类，如长度小于4、长度大于12、包含前导零、不包含前导零、数字超出0-255范围等。
    // 2. 边界值分析：测试输入字符串在边界值上的行为，如长度为4、12，数字为0、255等。
    // 3. 正面测试用例：测试能够形成有效IP地址的输入。
    // 4. 负面测试用例：测试不能形成有效IP地址的输入。

    // 测试方法：testValidIpAddresses
    // 测试目的：验证程序能够正确生成所有可能的有效IP地址。
    // 用到的测试用例："25525511135"
    @Test
    public void testValidIpAddresses() {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("25525511135");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("255.255.11.135"));
        assertTrue(result.contains("255.255.111.35"));
    }

    // 测试方法：testShortString
    // 测试目的：验证程序对于长度小于4的字符串不会生成任何IP地址。
    // 用到的测试用例："123"
    @Test
    public void testShortString() {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("123");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // 测试方法：testLongString
    // 测试目的：验证程序对于长度大于12的字符串不会生成任何IP地址。
    // 用到的测试用例："1234567890123"
    @Test
    public void testLongString() {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("1234567890123");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    // 测试方法：testLeadingZeros
    // 测试目的：验证程序能够正确处理包含前导零的字符串。
    // 用到的测试用例："0000" 和 "010010"
    @Test
    public void testLeadingZeros() {
        Solution solution = new Solution();
        List<String> result1 = solution.restoreIpAddresses("0000");
        assertNotNull(result1);
        assertEquals(1, result1.size());
        assertTrue(result1.contains("0.0.0.0"));

        List<String> result2 = solution.restoreIpAddresses("010010");
        assertNotNull(result2);
        assertTrue(result2.contains("1.0.0.10") || result2.contains("1.0.10.0") || result2.contains("10.0.1.0"));
        // 注意：这里可能有多个有效IP地址，只要有一个就认为测试通过
    }

    // 测试方法：testOutOfRangeNumbers
    // 测试目的：验证程序对于包含超出0-255范围数字的字符串不会生成任何IP地址。
    // 用到的测试用例："25625511135" 和 "9999999999"
    @Test
    public void testOutOfRangeNumbers() {
        Solution solution = new Solution();
        List<String> result1 = solution.restoreIpAddresses("25625511135");
        assertNotNull(result1);
        assertTrue(result1.isEmpty());

        List<String> result2 = solution.restoreIpAddresses("9999999999");
        assertNotNull(result2);
        assertTrue(result2.isEmpty());
    }

    // 测试方法：testNoValidIpAddresses
    // 测试目的：验证程序对于无法形成任何有效IP地址的字符串不会生成任何IP地址。
    // 用到的测试用例："1234567890ab"
    @Test
    public void testNoValidIpAddresses() {
        Solution solution = new Solution();
        List<String> result = solution.restoreIpAddresses("1234567890ab");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }
}