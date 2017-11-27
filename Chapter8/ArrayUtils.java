package Chapter8;


public class ArrayUtils
{
    /**
     * ����һ�����߷��������߷������ַ����������ҵ���Ӧ���ַ���Ԫ�ص�λ��
     * @param array ����������
     * @param target �������ַ���
     * @return Ŀ���ַ������ֵ�λ��,-1�����Ҳ���
     */
    public static int search(String[] array, String target)
    {
        for (int i = 0 ; i < array.length ; i++ )
        {
            if (array[i] != null && array[i].equals(target))
            {
                return i;
            }
        }
        return -1;
    }
}
