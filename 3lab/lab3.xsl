<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 
<xsl:template match="/">
	<html>
		<body>
			<h1> Sort book by year</h1>
			<table border="1">
				<tr bgcolor="#d8ff00">
					<th>Title</th>
                    <th>Author</th>
					<th>Pages</th>
					<th>Binding</th>
					<th>Price in shoop</th>
	                <th>Year</th>
				</tr>
				<xsl:for-each select="myinterests/library/books/book">
                 <xsl:sort select="year"/>
                 <tr>
                    <td><xsl:value-of select="title"/></td>
                    <td><xsl:value-of select="author"/></td>
					<td><xsl:value-of select="pages"/></td>
					<td><xsl:value-of select="binding"/></td>
					<td><xsl:value-of select="priceinshoop"/></td>
		            <td><xsl:value-of select="year"/></td>
                 </tr>
                </xsl:for-each>
			</table>
			<br/>
			<h1> Music</h1>
			<table border="1">
			    <tr bgcolor="#ffad70">
				    <th>Artist</th>
					<th>Song</th>
					<th>Information flow rate</th>
					<th>Durability</th>
					<th>Released</th>
				</tr>
				<xsl:for-each select="myinterests/playlist/songs/song">
					<tr>
					<td><xsl:value-of select="artist"/></td>
					<td><xsl:value-of select="track"/></td>
					<td><xsl:value-of select="informationflowrate"/></td>
					<td><xsl:value-of select="durability"/></td>
					<td><xsl:value-of select="released"/></td>
					</tr>
				</xsl:for-each>
			</table>
			<br/>
			<h1> Auto park</h1>
			<table border="1">
			   <tr bgcolor="#e21fdc">
			   <th>Mark</th>
			   <th>Model</th>
			   <th>Torque</th>
		       <th>Engine capacity</th>
			   <th>Power</th>
			   <th>Type</th>
			   <th>Year</th>
			   </tr>
			   <xsl:for-each select="myinterests/autopark/cars/car">
				    <tr>
				    <td><xsl:value-of select="mark"/></td>
					<td><xsl:value-of select="model"/></td>
					<td><xsl:value-of select="torque"/></td>
					<td><xsl:value-of select="enginecapacity"/></td>
					<td><xsl:value-of select="power"/></td>
					<td><xsl:value-of select="type"/></td>
					<td><xsl:value-of select="year"/></td>
					</tr>
				</xsl:for-each>
			</table>
			<br/>
		<h1>Insert constant string in successfull case</h1>
        <table border="1">
        <tr bgcolor="Coral">
        <th>Band</th>
        <th>Amount Of People</th>
         </tr>
	     <xsl:for-each select="myinterests/flowers/bouquets/bouquet">
          <tr>
	     <td><xsl:value-of select="name"/></td>
		  <xsl:choose>
		   <xsl:when test="numberofflowers &gt; 9">
		    <td>Amount is greater then 9</td>
		   </xsl:when>
		   <xsl:otherwise>
		    <td><xsl:value-of select="numberofflowers"/></td>
		   </xsl:otherwise>
          </xsl:choose>		   
          </tr>
	     </xsl:for-each>
         </table>
			<br/>
         <h1>Insert numeration</h1>
        <table border="1">
       <tr bgcolor="#65bc71">
      <th>Id</th>
      <th>Bouquet</th>
	  <th>Number of flowers</th>
     </tr>
	<xsl:variable name="i" select="0" />
	 <xsl:for-each select="myinterests/flowers/bouquets/bouquet">
      <tr>
	  <td>
        <xsl:value-of select="position() - 1" />
	  </td>
	  <td><xsl:value-of select="name"/></td>
	  <td><xsl:value-of select="numberofflowers"/></td>
      </tr>
	  </xsl:for-each>
       </table>
			<br/>
<h1>Finding maximal/minimal element</h1>
<xsl:variable name="max">
 <xsl:for-each select="myinterests/library/books/book">
      <xsl:sort select="year" order="descending"/>
	  <xsl:if test="position() = 1"><xsl:value-of select="year"/></xsl:if>
 </xsl:for-each>
</xsl:variable>
Maximal year: <xsl:value-of select="$max"/>
<br/>
		<h1>Average arithmetical</h1>
Average price: <xsl:value-of select="sum(myinterests/library/books/book/pages) div count(myinterests/library/books/book/year)"/>
			
<h1>Sum of elements</h1>
Sum of book pages: <xsl:value-of select="sum(myinterests/library/books/book/pages)"/>
			</body>
		</html>
	</xsl:template>
	</xsl:stylesheet>
