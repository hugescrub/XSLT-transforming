<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <meta charset="utf-8"/>
                <title>List of all chat users</title>
            </head>
            <body>
                <div>
                    <h1>Users list</h1>
                    <table style="width:100%;" border="1">
                        <tr>
                            <th>id</th>
                            <th>fullname</th>
                            <th>email</th>
                            <th>country</th>
                            <th>town</th>
                            <th>registered</th>
                            <th>address</th>
                        </tr>
                        <xsl:for-each select="/Root/users/user">
                            <tr>
                                <td>
                                    <xsl:value-of select="./@id"/>
                                </td>
                                <td>
                                    <xsl:value-of select="fullname"/>
                                </td>
                                <td>
                                    <xsl:value-of select="email"/>
                                </td>
                                <td>
                                    <xsl:value-of select="country"/>
                                </td>
                                <td>
                                    <xsl:value-of select="town"/>
                                </td>
                                <td>
                                    <xsl:value-of select="registered"/>
                                </td>
                                <td>
                                    <xsl:value-of select="address"/>
                                </td>
                            </tr>
                        </xsl:for-each>
                        <tr>
                            <th>Users Count:</th>
                            <td>
                                <xsl:value-of select="count(//user)"/>
                            </td>

                            <th>Users from Vladimir:</th>
                            <td>
                                <xsl:value-of select="count(//user[town='Vladimir'])"/>
                            </td>
                        </tr>

                        <tr>
                            <th>Users from Russia:</th>
                            <td>
                                <xsl:value-of select="count(//user[country='Russia'])"/>
                            </td>

                            <th>Users from Moscow:</th>
                            <td>
                                <xsl:value-of select="count(//user[town='Moscow'])"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Users from Germany:</th>
                            <td>
                                <xsl:value-of select="count(//user[country='Germany'])"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Users from Poland:</th>
                            <td>
                                <xsl:value-of select="count(//user[country='Poland'])"/>
                            </td>
                        </tr>
                        <tr>
                            <th>Users from Austria:</th>
                            <td>
                                <xsl:value-of select="count(//user[country='Austria'])"/>
                            </td>
                        </tr>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>