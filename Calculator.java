import java.util.ArrayList;
import java.util.Scanner;
public class Calculator
{
	public static float result;
	public static boolean b;
	public static float memVal;
	public static int c;
	public static ArrayList<Float> history=new ArrayList<Float>();
	public Calculator()
	{
		result=0;
		b=false;
		memVal=0;
	}
	public static boolean ifNumber(char x)
	{
		if(x=='0'||x=='1'||x=='2'||x=='3'||x=='4'||x=='5'||x=='6'||x=='7'||x=='8'||x=='9')
			return true;
		return false;
	}
	public static boolean ifNumber1(String x)
	{
		for(int i=0;i<x.length();++i)
			if(x.charAt(i)=='1'||x.charAt(i)=='2'||x.charAt(i)=='3'||x.charAt(i)=='4'||x.charAt(i)=='5'||x.charAt(i)=='6'||x.charAt(i)=='7'||x.charAt(i)=='8'||x.charAt(i)=='9'||x.charAt(i)=='0')
				return true;
		return false;
	}
	public static boolean ifSign(String x)
	{
		if(x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/"))
			return true;
		return false;
	}
	public static float evaluate(String expression)
	{
		int i=0,j=0;
		float x,y,x1,y1;
		char sign,sign1;
		String z="";
		String w;
		c=-1;
		int p1,p2,p3;
		String[] q=expression.split(" ");
		if(expression.equals(""))
		{
			System.out.println("Invalid input."); 
			c=0;
			return Float.MIN_VALUE;
		}
		if(expression.charAt(0)!='('&&expression.charAt(0)!='+'&&expression.charAt(0)!='*'&&expression.charAt(0)!='/')
		{
			if(q.length==3&&q[0].isBlank()==false&&q[1].isBlank()==false&&q[2].isBlank()==false)
			{
				if(expression.length()<5||ifNumber(expression.charAt(expression.length()-1))==false)
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				else
					if(ifNumber(expression.charAt(0))==false&&expression.charAt(0)!='-')
					{
						System.out.println("Invalid input."); 
						c=0;
						return Float.MIN_VALUE;
					}
					else 
					{
						if(expression.charAt(0)=='-')
						{
							z+=expression.charAt(0);
							++i;
							if(ifNumber(expression.charAt(1))==false)
							{
								System.out.println("Invalid input."); 
								c=0;
								return Float.MIN_VALUE;
							}
							else
								while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
								{
									if(expression.charAt(i)=='.')
										++j;
									z+=expression.charAt(i);
									++i;
								}
						}
						else
							while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
							{
								if(expression.charAt(i)=='.')
									++j;
								z+=expression.charAt(i);
								++i;
							}
					}
				if(j>1)
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				x=Float.parseFloat(z);
				z="";
				j=0;
				if(ifNumber(expression.charAt(i-1))==true&&expression.charAt(i)==' '&&(expression.charAt(i+1)=='+'||expression.charAt(i+1)=='-'||expression.charAt(i+1)=='*'||expression.charAt(i+1)=='/')&&expression.charAt(i+2)==' ')
					sign=expression.charAt(i+1);
				else 
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				if(ifNumber(expression.charAt(i+3))==false&&expression.charAt(i+3)!='-')
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				else
				{
					if(expression.charAt(i+3)=='-')
					{
						z+=expression.charAt(i+3);
						if(ifNumber(expression.charAt(i+4))==false)
						{
							System.out.println("Invalid input."); 
							c=0;
							return Float.MIN_VALUE;
						}
						else
							for(i=i+4;i<=expression.length()-1;++i)
							{
								if(expression.charAt(i)=='.')
									++j;
								if(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
									z+=expression.charAt(i);
								else 
								{
									System.out.println("Invalid input."); 
									c=0;
									return Float.MIN_VALUE;
								}
							}
					}
					else
						for(i=i+3;i<=expression.length()-1;++i)
						{
							if(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
								z+=expression.charAt(i);
							else 
							{
								System.out.println("Invalid input."); 
								c=0;
								return Float.MIN_VALUE;
							}
						}
				}
				if(j>1)
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				y=Float.parseFloat(z);
				if(ifNumber(expression.charAt(i-1))==false||(sign=='/'&&y==0))
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				else 
				{
					if(sign=='+')
					{
						result=x+y;
						b=true;
						return result;
					}
					else
						if(sign=='-')
						{
							result=x-y;
							b=true;
							return result;
						}
						else
							if(sign=='/')
							{
								result=x/y;
								b=true;
								return result;
							}
							else
							{
								result=x*y;
								b=true;
								return result;
							}
				}
			}
			else
				if(q.length%2==1)
				{
					for(p1=0;p1<q.length;++p1)
						if(q[p1].isBlank()==false)
						{
							for(p2=0;p2<q.length/2;++p2)
								if(ifNumber1(q[2*p2])==true&&ifSign(q[2*p2+1])==true&&ifNumber1(q[q.length-1])==true)
								{
									w=q[0]+" "+q[1]+" "+q[2];
									w=Float.toString(evaluate(w));
									for(p3=0;p3<q.length-4;++p3)
									{
										w=w+" "+q[p3+3]+" "+q[p3+4];
										++p3;
										w=Float.toString(evaluate(w));
									}
									return Float.parseFloat(w);
								}
						}
				}
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
		}
		else
			if(expression.charAt(0)=='+'||expression.charAt(0)=='-'||expression.charAt(0)=='*'||expression.charAt(0)=='/')
			{
				if(expression.length()<3||ifNumber(expression.charAt(expression.length()-1))==false)
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				else
					sign=expression.charAt(0);
				if(expression.charAt(1)!=' '&&ifNumber(expression.charAt(2))==false&&expression.charAt(2)!='-')
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				else
				{
					if(expression.charAt(2)=='-')
					{
						z+=expression.charAt(2);
						if(ifNumber(expression.charAt(3))==false)
						{
							System.out.println("Invalid input."); 
							c=0;
							return Float.MIN_VALUE;
						}
						else
							for(i=3;i<=expression.length()-1;++i)
							{
								if(expression.charAt(i)=='.')
									++j;
								if(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
									z+=expression.charAt(i);
								else 
								{
									System.out.println("Invalid input.");
									c=0;
									return Float.MIN_VALUE;
								}
							}
					}
					else
						for(i=2;i<=expression.length()-1;++i)
						{
							if(expression.charAt(i)=='.')
								++j;
							if(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
								z+=expression.charAt(i);
							else 
							{
								System.out.println("Invalid input.");
								c=0;
								return Float.MIN_VALUE;
							}
						}
				}
				if(j>1)
				{
					System.out.println("Invalid input.");
					c=0;
					return Float.MIN_VALUE;
				}
				x=Float.parseFloat(z);
				if(ifNumber(expression.charAt(i-1))==false||(sign=='/'&&x==0))
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				else 
				{
					if(sign=='+')
					{
						result=memVal+x;
						b=true;
						return result;
					}
					else
						if(sign=='-')
						{
							result=memVal-x;
							b=true;
							return result;
						}
						else
							if(sign=='/')
							{
								result=memVal/x;
								b=true;
								return result;
							}
							else
							{
								result=memVal*x;
								b=true;
								return result;
							}
				}
			}
		else
		{
			++i;
			if(expression.length()<17||expression.charAt(expression.length()-1)!=')')
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			else 
			{
				if(ifNumber(expression.charAt(1))==false&&expression.charAt(1)!='-')
				{
					System.out.println("Invalid input."); 
					c=0;
					return Float.MIN_VALUE;
				}
				else 
				{
					if(expression.charAt(1)=='-')
					{
						z+=expression.charAt(1);
						++i;
						if(ifNumber(expression.charAt(2))==false)
						{
							System.out.println("Invalid input.");
							c=0;
							return Float.MIN_VALUE;
						}
						else
							while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
							{
								if(expression.charAt(i)=='.')
									++j;
								z+=expression.charAt(i);
								++i;
							}
					}
					else
						while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
						{
							if(expression.charAt(i)=='.')
								++j;
							z+=expression.charAt(i);
							++i;
						}
				}
			}
			if(j>1)
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			x=Float.parseFloat(z);
			z="";
			j=0;
			if(ifNumber(expression.charAt(i-1))==true&&expression.charAt(i)==' '&&(expression.charAt(i+1)=='+'||expression.charAt(i+1)=='-'||expression.charAt(i+1)=='*'||expression.charAt(i+1)=='/')&&expression.charAt(i+2)==' ')
				sign=expression.charAt(i+1);
			else 
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			if(ifNumber(expression.charAt(i+3))==false&&expression.charAt(i+3)!='-')
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			else
			{
				if(expression.charAt(i+3)=='-')
				{
					z+=expression.charAt(i+3);
					if(ifNumber(expression.charAt(i+4))==false)
					{
						System.out.println("Invalid input."); 
						c=0;
						return Float.MIN_VALUE;
					}
					else
					{
						i+=4;
						while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
						{
							if(expression.charAt(i)=='.')
								++j;
							z+=expression.charAt(i);
							++i;
						}
					}
				}
				else
				{
					i+=3;
					while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
					{
						if(expression.charAt(i)=='.')
							++j;
						z+=expression.charAt(i);
						++i;
					}
				}
			}
			if(j>1)
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			y=Float.parseFloat(z);
			z="";
			j=0;
			if(ifNumber(expression.charAt(i-1))==false||(sign=='/'&&y==0))
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			else
			{
				if(sign=='+')
					x1=x+y;
				else
					if(sign=='-')
						x1=x-y;
				else
					if(sign=='/')
						x1=x/y;
				else
					x1=x*y;
			}
			if(ifNumber(expression.charAt(i-1))==true&&expression.charAt(i)==')'&&expression.charAt(i+1)==' '&&(expression.charAt(i+2)=='+'||expression.charAt(i+2)=='-'||expression.charAt(i+2)=='*'||expression.charAt(i+2)=='/')&&expression.charAt(i+3)==' '&&expression.charAt(i+4)=='(')
				sign1=expression.charAt(i+2);
			else 
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			if(ifNumber(expression.charAt(i+5))==false&&expression.charAt(i+5)!='-')
			{
				System.out.println("Invalid input.");
				c=0;
				return Float.MIN_VALUE;
			}
			else
			{
				i+=5;
				if(expression.charAt(i)=='-')
				{
					z+=expression.charAt(i);
					++i;
					if(ifNumber(expression.charAt(i))==false)
					{
						System.out.println("Invalid input."); 
						c=0;
						return Float.MIN_VALUE;
					}
					else
						while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
						{
							if(expression.charAt(i)=='.')
								++j;
							z+=expression.charAt(i);
							++i;
						}
				}
				else
					while(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
					{
						if(expression.charAt(i)=='.')
							++j;
						z+=expression.charAt(i);
						++i;
					}
			}
			if(j>1)
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			x=Float.parseFloat(z);
			z="";
			j=0;
			if(ifNumber(expression.charAt(i-1))==true&&expression.charAt(i)==' '&&(expression.charAt(i+1)=='+'||expression.charAt(i+1)=='-'||expression.charAt(i+1)=='*'||expression.charAt(i+1)=='/')&&expression.charAt(i+2)==' ')
				sign=expression.charAt(i+1);
			else 
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			if(ifNumber(expression.charAt(i+3))==false&&expression.charAt(i+3)!='-')
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			else
			{
				if(expression.charAt(i+3)=='-')
				{
					z+=expression.charAt(i+3);
					if(ifNumber(expression.charAt(i+4))==false)
					{
						System.out.println("Invalid input."); 
						c=0;
						return Float.MIN_VALUE;
					}
					else
						for(i=i+4;i<=expression.length()-2;++i)
						{
							if(expression.charAt(i)=='.')
								++j;
							if(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
								z+=expression.charAt(i);
							else 
							{
								System.out.println("Invalid input."); 
								c=0;
								return Float.MIN_VALUE;
							}
					}
				}
				else
					for(i=i+3;i<=expression.length()-2;++i)
					{
						if(ifNumber(expression.charAt(i))==true||expression.charAt(i)=='.')
							z+=expression.charAt(i);
						else 
						{
							System.out.println("Invalid input."); 
							c=0;
							return Float.MIN_VALUE;
						}
					}
			}
			if(j>1)
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			y=Float.parseFloat(z);
			if(ifNumber(expression.charAt(i-1))==false||expression.charAt(i)!=')'||(sign=='/'&&y==0))
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			else
			{
				if(sign=='+')
					y1=x+y;
				else
					if(sign=='-')
						y1=x-y;
				else
					if(sign=='/')
							y1=x/y;
				else
					y1=x*y;
			}
			if(sign1=='/'&&y1==0)
			{
				System.out.println("Invalid input."); 
				c=0;
				return Float.MIN_VALUE;
			}
			else
			{
				if(sign1=='+')
				{
					result=x1+y1;
					b=true;
					return result;
				}
				else
					if(sign1=='-')
					{
						result=x1-y1;
						b=true;
						return result;
					}
					else
						if(sign1=='/')
						{
							result=x1/y1;
							b=true;
							return result;
						}
					else
					{
						result=x1*y1;
						b=true;
						return result;
					}
			}
		}
	}
	public static float getCurrentValue()
	{
		return result;
	}
	public static float getMemoryValue()
	{
		if(b==true)
			return memVal;
		return 0;
	}
	public static void setMemoryValue(float memval)
	{
		memVal=memval;
		b=true;
	}
	public static void clearMemory()
	{
		memVal=0;
	}
	public static void history()
	{
		if(c==-1)
			history.add(result);
	}
	public static float getHistoryValue(int index)
	{
		return history.get(index);
	}
	public static void main(String[] args) 
	{
		String s,input;
		Scanner in=new Scanner(System.in);
		while(true)
		{
			System.out.print("Enter an expression: ");
			s=in.nextLine();		
			evaluate(s);
			history();
			System.out.println(getCurrentValue());
			System.out.print("Type an option: ");
			input=in.nextLine();
			if(input.equals("m"))
			{
				if(c==0)
					setMemoryValue(0);
				else
					setMemoryValue(getCurrentValue());
			}
			else
				if(input.equals("mr"))
				{
					System.out.println("The stored memory value is: "+getMemoryValue()+" ");
				}
			else
				if(input.equals("c"))
				{
					clearMemory();
				}
			else
				if(input.equals("h"))
				{
					int index;
					for(index=0;index<history.size();++index)	
						System.out.print(getHistoryValue(index)+" ");
					System.out.println();
				}
			else
				if(input.equals("EXIT"))
					break;
		}
		in.close();
		System.out.println("Calculator stopped.");
	}
}
