import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtilTest {

    @Test
    @DisplayName("TestUtil.getScanner()")
    void t1() {

        Scanner sc = TestUtil.getScanner("""
                등록
                너 자신을 알라
                소크라테스
                """
        );

        String cmd = sc.nextLine(); //등록
        String saying = sc.nextLine(); //너 자신을 알라
        String author = sc.nextLine(); //소크라테스

        assertThat(cmd).isEqualTo("등록");
        assertThat(saying).isEqualTo("너 자신을 알라");
        assertThat(author).isEqualTo("소크라테스");
    }

    @Test
    @DisplayName("TestUtil.setOutToByteArray()")
    void t2() throws IOException {
        // 출력 저장소 생성 + System.out을 메모리로 돌려놓음
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();

        System.out.println("1 / 이순신 / 나의 죽음을 적에게 알리지 마라"); //outputStream 안에 저장됨

        String outStr = outputStream.toString(); //메모리에 쌓인 내용을 문자열로 꺼냄.

        TestUtil.clearSetOutToByteArray(outputStream); //System.out 을 다시 원래 콘솔로 복구.

        assertThat(outStr).contains("1 / 이순신 / 나의 죽음을 적에게 알리지 마라");

        System.out.println("이제 화면에 출력된다."); //System.out 복구했으니까 다시 화면에 찍힘.
    }
}
