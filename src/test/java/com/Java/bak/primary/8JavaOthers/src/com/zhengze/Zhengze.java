package com.zhengze;
/*
 *\\d ���֣�[0-9]
 * */
public class Zhengze {
	public static void main(String[] args) {
		String str="zhang54321wu";
		String str1=str.replaceAll("\\d", "-");	//���������֣�\\d���滻��-
		System.out.println(str1);
		System.out.println("a".matches("."));	//"."���������ַ�
		System.out.println("a".matches("a*"));	//* �������0�˻��߶��
		System.out.println("abcc".matches("a?"));	//? �������1�λ���һ�ζ�û��	false	�ַ�����1���ַ�ƥ�䣬���Ǻ��治ƥ�䣬�������岻ƥ��
		System.out.println("bbbbb".matches("b+"));	//+ �������1�λ��߶�Ρ�		true
		System.out.println("12234578999322".matches("\\d{3,100}"));	//���ֳ���3��100��
		System.out.println("192.168.2.234".matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"));//�� \\.��Ϊ�ָ�
		System.out.println("192z168z2z234".matches("\\d{1,3}z\\d{1,3}z\\d{1,3}z\\d{1,3}")); //z��������ʽ��û�����⺬�壬���Բ���Ҫת��
		System.out.println("192".matches("[0-2][0-9][1-2]"));//�����Ŵ���1���ַ�
		System.out.println("a".matches("[abc]"));
		System.out.println("ab".matches("[abcv]"));//[] ƥ�����1���ַ�
		System.out.println("a".matches("[a-z[A-Z]]"));
		System.out.println("a".matches("[a-z]|[A-Z]"));	//����һ����ͬ���ǲ���
		System.out.println("a".matches("[a-z]&[A-Z]"));	//����	
		System.out.println("a_8".matches("\\w{3}"));	//\\w ��ʾ�����ַ���[a-zA-Z_0-9] �������»��ߣ�������3��
		
		System.out.println("hello world".matches("^h.*"));//��h��ͷ������������ַ�����0�λ��߶��
		System.out.println("hello world".matches("^h"));//�����ַ�������ƥ��ġ�--->false
		System.out.println("hello world".matches(".*ld$"));//$--->�еĽ�β
		System.out.println("hello world".matches("^h[a-z]{1,3}o\\b.*"));//  o\\b�� ��oΪ���ʱ߽�
		
		
		System.out.println("\r\f\n".matches("^[\\s&&[^\\n]]*\\n$"));//��\\s���\\n�Ľ���Ϊ��ͷ�����ַ�����0�λ��߶�Σ������\n��β
		System.out.println("aaa 9999c".matches(".*\\d{4}."));
		System.out.println("sdfa 9939".matches(".*a [\\d]{4}"));
		
		
	}
}
