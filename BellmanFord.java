import java.util.*;

class BellmanFord
{
	int s;
	int n;
	int[][] a;
	int[] d;
	int[] p;
	int INFTY=9999;

	void input()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes: ");
		n = sc.nextInt();
		System.out.println("Enter the graph values: ");
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<n; j++)
			{
				a[i][j]=sc.nextInt();
				if (i!=j && a[i][j]==0)
					a[i][j] = INFTY;
			}
		}
		System.out.println("Enter the source vertex: ");
		s = sc.nextInt();
		sc.close();
	}

	void path(int v)
	{
		if (v == -1)
			return;
		path(p[v]);
		System.out.println("."+p[v]);
	}

	void bellmanFord()
	{
		for(int i=1; i<n; i++)
		{
			d[i] = a[s][i];
			p[i] = (a[s][i] == INFTY) ? -1 : s;
		}
		p[s] = -1;

		for(int i=0; i<n-1; i++)
		{
			for(int u=0; u<n; u++)
			{
				for(int v=0; v<n; v++)
				{
					if (d[v] > d[u]+d[v])
					{
						d[v] = d[u] + a[u][v];
						p[v] = u;
					}
				}
			}
		}
	}

	void output()
	{
		for(int i=0; i<n; i++)
		{
			System.out.print("d("+s+","+i+")="+d[i]+" :p");
			path(i);
			System.out.println();
		}
	}

	public static void main(String[] args)
	{
		BellmanFord bf = new BellmanFord();
		bf.input();
		bf.bellmanFord();
		bf.output();
	}
}
